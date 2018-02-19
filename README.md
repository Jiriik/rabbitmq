# Rabbit MQ Sandbox Project

One Paragraph of project description goes here

## Useful stuff
* Installation directory : `/usr/local/sbin/`
* [http://SERVER:15672/](http://localhost:15672/#//) - RabbitMQ Web Console
* [README.md template](https://gist.github.com/Jiriik/ab49a50c09d654ca6bb794b31c36cd6e) - RabbitMQ Web Console

### Useful shell commands
* Print `messages_unacknowledged` field
```
sudo rabbitmqctl list_queues name messages_ready messages_unacknowledged
```

