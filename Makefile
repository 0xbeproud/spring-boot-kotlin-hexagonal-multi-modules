MYSQL_CLIENT_VERSION=8.0.32

# lint
lint-check:
	./gradlew ktlintCheck

lint:
	./gradlew ktlintFormat

done: lint