import pika
import os
from datetime import datetime

url = os.environ.get('CLOUDAMQP_URL', 'amqps://qytieuev:rAGCz9XyS_MAQtL4uEsx5IaJ5ep9JVCz@jackal.rmq.cloudamqp.com/qytieuev')
params = pika.URLParameters(url)
connection = pika.BlockingConnection(params)
channel = connection.channel()

exchange_name = 'emergencia-topic-exchange'
channel.exchange_declare(exchange=exchange_name, exchange_type='topic', durable=True)

tipos_validos = {
    '1': 'policia',
    '2': 'bombeiros',
    '3': 'ambulancia'
}

print("\n=== ENVIO DE MENSAGEM DE EMERGÊNCIA ===")
print("Tipos de emergência:")
print("1. Polícia")
print("2. Bombeiros")
print("3. Ambulância")

tipo = input("Escolha o tipo (1/2/3): ").strip()
if tipo not in tipos_validos:
    print("Tipo inválido. Encerrando.")
    connection.close()
    exit()

local = input("Informe o local da emergência: ").strip()
descricao = input("Descreva a situação: ").strip()

tipo_emergencia = tipos_validos[tipo]
routing_key = f"emergencia.{tipo_emergencia}"

# Adiciona data e hora no formato desejado
data_hora = datetime.now().strftime("%d/%m/%Y - %H:%M")
mensagem = f"[{data_hora}] [{tipo_emergencia.upper()}] EMERGÊNCIA EM: {local} | {descricao}"

channel.basic_publish(
    exchange=exchange_name,
    routing_key=routing_key,
    body=mensagem.encode(),
    properties=pika.BasicProperties(
        delivery_mode=2
    )
)

print(f"\n[x] Mensagem enviada com sucesso para '{routing_key}':\n-> {mensagem}")
connection.close()
