# spring-boot-kotlin-hexagonal-multi-modules

> 공부하면서 정리중입니다

전체적인 내용은 [Spring Boot Kotlin Multi Module로 구성해보는 헥사고날 아키텍처](https://techblog.woowahan.com/12720/)을 참고하였습니다.

![Hexagonal Architecture](docs/images/100-explicit-architecture-svg.png)
[그림 1] 출처: https://herbertograca.com/tag/explicit-architecture

```bash
❯ tree -d -L 2
.
├── application
├── bootstrap
│   └── api
├── domain
└── framework
    └── rds

```

## domain module
- [그림 1] Domain Layer 영역

## application module
- [그림 1] Application Layer 영역

## framework module
- [그림 1] Secondary/Driven Adapters (Infrastructure) 영역

## bootstrap module
- [그림 1] Primary/Driving Adapters (User Interface) 영역


참고)
- https://techblog.woowahan.com/12720/
- https://velog.io/@qkrdbqls1001/%EC%9E%90%EB%B0%94-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90-Hexagonal-architecture-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
- https://github.com/Sachena/board_hexagonal