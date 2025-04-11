import pika
import os

url = os.environ.get('CLOUDAMQP_URL', 'amqps://qytieuev:rAGCz9XyS_MAQtL4uEsx5IaJ5ep9JVCz@jackal.rmq.cloudamqp.com/qytieuev')
params = pika.URLParameters(url)
connection = pika.BlockingConnection(params)
channel = connection.channel()

exchange_name = 'emergencia-topic-exchange'
fila_auditoria = 'fila-auditoria'

channel.exchange_declare(exchange=exchange_name, exchange_type='topic', durable=True)

channel.queue_declare(queue=fila_auditoria, durable=True)

channel.queue_bind(exchange=exchange_name, queue=fila_auditoria, routing_key='emergencia.#')

print("\n=== AUDITORIA DE EMERGÊNCIAS ===")
print("Aguardando todas as mensagens... (Ctrl+C para sair)\n")

def callback(ch, method, properties, body):
    print(f"[AUDITOR] Recebido de {method.routing_key}: {body.decode()}")

channel.basic_consume(queue=fila_auditoria, on_message_callback=callback, auto_ack=True)

try:
    channel.start_consuming()
except KeyboardInterrupt:
    print("\nEncerrando auditoria...")
    connection.close()
