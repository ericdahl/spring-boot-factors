appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d [%thread] %highlight(%-5level) [%logger] %msg%n"
  }
}

root(INFO, ["STDOUT"])