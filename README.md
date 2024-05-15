# spring-boot-kotlin-hexagonal-multi-modules

> 제가 코드를 봐야 이해가 빠르게 되어서 코드를 작성하면서 정리하고 있습니다.

전체적인 내용은 [Spring Boot Kotlin Multi Module로 구성해보는 헥사고날 아키텍처](https://techblog.woowahan.com/12720/)을 참고하였습니다.

code는 user위주로 보시면 될 것 같고, community는 여러 도메인을 다루는 경우 어떤 구조가 좋을까 싶어서 구조만 잡아놨습니다.

학습용으로 만들고 있는 프로젝트가 있는데, 이 아키텍처를 적용해보려고 합니다.

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