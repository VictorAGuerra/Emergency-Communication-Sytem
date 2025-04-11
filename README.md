# 🆘 Emergency Communication System

This project simulates a communication system between **citizens** and **emergency response centers** using **RabbitMQ (AMQP)**. The goal is to allow citizens to send emergency messages to specific services (Police, Firefighters, Ambulance), with support for audit logging and multiple consumer instances.

---

## 🧱 Project Structure

- `/centrais` → Spring Boot project with consumers (Java)
- `produtor.py` → Python script for sending messages (citizen)
- `auditor.py` → Python script that receives all messages (audit)
- `menu.sh` → Interactive menu to run the options

---

## 📦 Technologies Used

- Java 17 + Spring Boot (consumers)
- Python 3 + pika (producer and audit)
- RabbitMQ via [CloudAMQP](https://www.cloudamqp.com/)
- Maven

---

## 🚀 How to Run

### Prerequisites

- RabbitMQ configured (CloudAMQP)
- Python 3 installed
- Java 17+ and Maven installed
- `pika` installed for Python:

```bash
pip install pika

```

---


# 🆘 Sistema de Comunicação de Emergência

Este projeto simula um sistema de comunicação entre **cidadãos** e **centrais de atendimento de emergência** usando **RabbitMQ (AMQP)**. O objetivo é permitir o envio de mensagens de emergência para centrais específicas (Polícia, Bombeiros e Ambulância), com suporte a auditoria e múltiplas instâncias de consumidores.

---

## 🧱 Estrutura do Projeto

- `/centrais` → Projeto Spring Boot com consumidores (Java)
- `produtor.py` → Script Python de envio de mensagens (cidadão)
- `auditor.py` → Script Python que recebe todas as mensagens (auditoria)
- `menu.sh` → Menu interativo para executar as opções

---

## 📦 Tecnologias Usadas

- Java 17 + Spring Boot (consumidores)
- Python 3 + pika (produtor e auditoria)
- RabbitMQ via [CloudAMQP](https://www.cloudamqp.com/)
- Maven

---

## 🚀 Como Executar

### Pré-requisitos

- RabbitMQ configurado (CloudAMQP)
- Python 3 instalado
- Java 17+ e Maven instalados
- `pika` instalado no Python:

```bash
pip install pika
