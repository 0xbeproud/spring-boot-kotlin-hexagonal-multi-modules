# spring-boot-kotlin-hexagonal-multi-modules

> 아직 완벽히 이해하지 못한 상태이고 공부중입니다.

[Spring Boot Kotlin Multi Module로 구성해보는 헥사고날 아키텍처](https://techblog.woowahan.com/12720/)을 참고하였습니다.

![Hexagonal Architecture](docs/images/100-explicit-architecture-svg.png)
[그림 1] 출처: https://herbertograca.com/tag/explicit-architecture

```bash
.
├── application
├── bootstrap
├── domain
└── framework
   └── rds
```

## domain module
- [그림 1] Domain Layer 영역
- DDD(도메인 주도 개발)의 그 Domain Layer로 기술에 독립적인 POJO로 개발
- 실제로 gradle에 어떤 dependency도 포함하지 않음

## application module
- [그림 1] Application Layer 영역
- 의존성은 Domain Hexagon에 대해서만 가짐
- 공부중..

## framework module
- [그림 1] Secondary/Driven Adapters (Infrastructure) 영역
- Application hexagon이 소유한 outputPort (interface) 구현체들의 집합
- Framework Hexagon은 여러 개의 module로 분리, 관리
    - Mysql, MongoDB, Redis 등등을 넣으면 될듯?

## bootstrap module
- [그림 1] Primary/Driving Adapters (User Interface) 영역
- 프로그램의 기능을 사용하기 위한 시작점


## 공부중..

bootstrap에 api, batch를 배치했는데, batch가 여기에 있는게 맞는건가?
(기존에 multi module 구성시 :app:api, :app:batch, :app:worker등으로 나누었어서 일단 bootstrap에 batch를 추가함.)

참고)
https://techblog.woowahan.com/12720/
https://velog.io/@qkrdbqls1001/%EC%9E%90%EB%B0%94-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90-Hexagonal-architecture-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
https://github.com/Sachena/board_hexagonal