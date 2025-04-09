import pika
import os

url = os.environ.get('CLOUDAMQP_URL', 'amqps://qytieuev:rAGCz9XyS_MAQtL4uEsx5IaJ5ep9JVCz@jackal.rmq.cloudamqp.com/qytieuev')
params = pika.URLParameters(url)
connection = pika.BlockingConnection(params)
channel = connection.channel()

exchange_name = 'emergencia-topic-exchange'
channel.exchange_declare(exchange=exchange_name, exchange_type='topic', durable=True)

# Criar uma fila temporária (exclusiva)
result = channel.queue_declare('', exclusive=True)
queue_name = result.method.queue

# Assinar para todas as emergências
channel.queue_bind(exchange=exchange_name, queue=queue_name, routing_key='emergencia.#')

print("\n=== AUDITORIA DE MENSAGENS DE EMERGÊNCIA ===")
print("Aguardando todas as mensagens enviadas...\n")

def callback(ch, method, properties, body):
    print(f"\n[AUDITORIA] Recebido de {method.routing_key}: {body.decode()}")

channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

try:
    channel.start_consuming()
except KeyboardInterrupt:
    print("\nEncerrando auditoria...")
    connection.close()
