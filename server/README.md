Fluxo Completo:

1. **Requisição**: O cliente faz uma requisição `POST /api/polls` com os dados da nova enquete.
2. **Controlador**: A requisição é recebida pelo `PollController`.
3. **Segurança**: O token JWT do usuário é verificado para autenticação e autorização.
4. **Validação**: Os dados da requisição são validados. Se houver algum problema, uma exceção é lançada.
5. **Serviço**: O `PollController` chama o `PollService` para processar a criação da enquete.
6. **Repositório**: O `PollService` utiliza o `PollRepository` para salvar a enquete no banco de dados.
7. **Modelos**: A enquete é mapeada para uma entidade `Poll` e salva.
8. **Payload**: O `PollService` retorna um objeto `PollResponse` ao `PollController`.
9. **Resposta**: O `PollController` envia o `PollResponse` de volta ao cliente, indicando que a enquete foi criada com sucesso.
10. **Tratamento de Erros**: Se algum erro ocorrer em qualquer etapa, uma exceção é lançada e uma resposta de erro é enviada ao cliente.

```markdown
## Estrutura do Projeto

```plaintext
src/
 ├── main/
 │   ├── java/
 │   │   └── com/
 │   │       └── example/
 │   │           └── polls/
 │   │               ├── config/        # Configurações de aplicação
 │   │               ├── controllers/   # Controladores da API
 │   │               ├── exceptions/    # Tratamento de exceções
 │   │               ├── models/        # Modelos de dados
 │   │               │   └── audit/     # Classes de auditoria
 │   │               ├── payloads/      # DTOs e classes de transferência de dados
 │   │               ├── repository/    # Repositórios JPA
 │   │               ├── security/      # Configurações e serviços de segurança
 │   │               ├── service/       # Serviços de negócio
 │   │               └── util/          # Classes utilitárias
 │   └── resources/
 │       └── application.properties     # Configurações de propriedades
