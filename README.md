# java-blackjack
블랙잭 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

### 기능 구현 목록
- [x] 게임에 참여할 사람 이름 입력받기
  - [x] 쉼표 기준으로 분리하기
  - [x] 쉼표 기준으로 분리 후, 양쪽 공백 제거하기
  - [x] [예외처리] 이름은 1글자 이상이어야 한다.
- [x] 카드 덱 구성하기
  - [x] 카드 덱 셔플하기
  - [x] 카드가 다 떨어질 경우, 새로운 카드 덱 생성
  - [x] 게임 시작 할 때 딜러와 플레이어한테 2장의 카드를 지급하기
  - [x] 카드 덱으로부터 2장 카드 리턴하는 기능
- [x] 각 플레이어가 가진 카드 현황을 출력하는 기능
- [ ] Ace가 상황에 따라 1, 11로 사용할 수 있는 기능
- [x] 플레이어한테 추가로 카드를 지급 받을 지 안 받을 지 물어보기
  - [x] 플레이어한테 추가로 카드 1장을 지급하는 기능
  - [x] [예외처리] 카드의 합이 21을 초과할 경우 카드를 계속 뽑을 수 없다.  
- [ ] 딜러는 처음에 받은 2장의 합계가 16 이하면 1장의 카드를 더 받고, 17점 이상이면 추가로 받지 않도록 만들기
    - [ ] 딜러가 카드를 더 받을 경우, 카드를 더 받았다는 문구 출력하기
    - [ ] 딜러한테 추가로 카드 지급하는 기능
- [ ] 게임을 완료한 후 각 플레이어별로 승패를 출력한다.
  - [ ] 딜러, 플레이어 둘 다 21을 초과할 경우, 플레이어의 패이다. 
  - [ ] 플레이어만 21을 초과할 경우, 플레이어의 패이다.
  - [ ] 딜러, 플에이어 둘 다 21을 초과하지 않았을 때는, 21에 가까운 쪽이 승리한다.
  - [ ] 플레이어들끼리는 경쟁하지 않고, 오로지 플레이어와 딜러의 숫자만 가지고 승패를 결정한다. 
    
    
