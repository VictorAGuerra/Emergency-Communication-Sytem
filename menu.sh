#!/bin/bash

echo "=== CENTRAIS DE EMERGÊNCIA ==="
echo "Escolha o consumidor para iniciar:"
echo "1. Central - Polícia"
echo "2. Central - Bombeiros"
echo "3. Central - Ambulância"
echo "4. Todas as centrais (juntas)"
echo "==============================="
echo "5. Atendimento Emergencial"
echo "==============================="
echo "6. Auditoria"
echo "7. Sair"

read -p "Opção: " opcao

case $opcao in
    1)
        echo "Iniciando central da POLÍCIA..."
        cd centrais; ./mvnw spring-boot:run -Dspring-boot.run.profiles=policia
        ;;
    2)
        echo "Iniciando central dos BOMBEIROS..."
        cd centrais; ./mvnw spring-boot:run -Dspring-boot.run.profiles=bombeiros
        ;;
    3)
        echo "Iniciando central da AMBULÂNCIA..."
        cd centrais; ./mvnw spring-boot:run -Dspring-boot.run.profiles=ambulancia
        ;;
    4)
        echo "Iniciando TODAS as centrais..."
        cd centrais; ./mvnw spring-boot:run -Dspring-boot.run.profiles=policia,bombeiros,ambulancia
        ;;
    5)
        echo "Iniciando atendimento EMERGENCIAL..."
        python produtor.py
        ;;
    6)
        echo "Iniciando AUDITOR..."
        python auditor.py
        ;;
    9)
        echo "Saindo..."
        exit 0
        ;;
    *)
        echo "Opção inválida!"
        ;;
esac
