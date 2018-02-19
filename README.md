# Rabbit MQ Sandbox Project

One Paragraph of project description goes here

## Useful stuff
* [http://SERVER:15672/](http://localhost:15672/#/) - RabbitMQ Web Console
* [Tutorials](https://www.rabbitmq.com/getstarted.html) - Tutorials
* [README.md template](https://gist.github.com/Jiriik/ab49a50c09d654ca6bb794b31c36cd6e) - README.md template

### Useful shell commands
* Installation directory : `/usr/local/sbin/`
* Start the server: `rabbitmq-server -detached` ([more](https://www.rabbitmq.com/install-standalone-mac.html))
* Print `messages_unacknowledged` field
```
sudo rabbitmqctl list_queues name messages_ready messages_unacknowledged
```

