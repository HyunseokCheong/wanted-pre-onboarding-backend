- [x] 과제 1. 사용자 회원가입 엔드포인트 `feat: add user signup endpoint`
    - [x] 이메일과 비밀번호로 회원가입할 수 있는 엔드포인트
    - [x] 이메일과 비밀번호에 대한 유효성 검사
    - [x] 이메일 조건: @ 포함
    - [x] 비밀번호 조건: 8자 이상
    - [x] 비밀번호는 반드시 암호화하여 저장
- [x] 과제 2. 사용자 로그인 엔드포인트 `feat: add user login endpoint`
    - [x] 사용자가 올바른 이메일과 비밀번호를 제공하면, 사용자 인증을 거친 후에 JWT(JSON Web Token)를 생성하여 사용자에게 반환
    - [x] 과제 1과 마찬가지로 로그인 엔드포인트에 이메일과 비밀번호의 유효성 검사기능을 구현
- [x] 과제 3. 새로운 게시글을 생성하는 엔드포인트 `feat: add article create endpoint`
- [x] 과제 4. 게시글 목록을 조회하는 엔드포인트 `feat: add find all article endpoint`
    - [x] 반드시 Pagination 기능을 구현
- [x] 과제 5. 특정 게시글을 조회하는 엔드포인트 `feat: add find article endpoint`
    - [x] 게시글의 ID를 받아 해당 게시글을 조회
- [x] 과제 6. 특정 게시글을 수정하는 엔드포인트 `feat: add update article endpoint`
    - [x] 게시글의 ID와 수정 내용을 받아 해당 게시글을 수정
    - [x] 게시글을 수정할 수 있는 사용자는 게시글 작성자만 가능
- [x] 과제 7. 특정 게시글을 삭제하는 엔드포인트 `feat: add delete article endpoint`
    - [x] 게시글의 ID를 받아 해당 게시글을 삭제
    - [x] 게시글을 삭제할 수 있는 사용자는 게시글 작성자만 가능

# 기입할 내용
- 지원자의 성명
- 애플리케이션의 실행 방법 (엔드포인트 호출 방법 포함)
- 데이터베이스 테이블 구조
- 구현한 API의 동작을 촬영한 데모 영상 링크
- 구현 방법 및 이유에 대한 간략한 설명
- API 명세(request/response 포함)

# 추가 내용
- 통합 테스트 또는 단위 테스트 코드를 추가한 경우
- docker compose를 이용하여 애플리케이션 환경을 구성한 경우 (README.md 파일에 docker-compose 실행 방법 반드시 기입)
- 클라우드 환경(AWS, GCP)에 배포 환경을 설계하고 애플리케이션을 배포한 경우 (README.md 파일에 배포된 API 주소와 설계한 AWS 환경 그림으로 첨부)
