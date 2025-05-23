# Java-Kiosk 🍔

간편한 키오스크 시스템을 자바로 구현한 프로젝트입니다. 메뉴 주문부터 결제까지 콘솔 기반으로 동작하는 시스템입니다.

## ✨ 주요 기능
다양한 메뉴 계층 구조 관리 (카테고리 → 상품)

장바구니 시스템 (추가/삭제/전체 삭제 기능)

할인 정책 적용 (국가유공자, 군인, 학생 할인)

입력 유효성 검증 (숫자만 입력 가능)

## 🎮 실행 방법
#### 프로젝트 클론

bash
git clone https://github.com/Gaeso/java-kiosk.git
컴파일 및 실행

## 📝 클래스 상세 설명
#### 1. Menu 클래스
메뉴 카테고리(버거, 음료 등) 관리

showMenuItems()로 메뉴 목록 표시

#### 2. OrderSystem 클래스
사용자 입력 처리 및 화면 흐름 제어

#### 3. ShoppingCart 클래스
주문 항목 저장 및 총액 계산

할인 적용 및 주문 완료 처리

removeIf()와 스트림으로 항목 제거

## 💡 개선 가능한 점
데이터를 외부 파일에서 로드하도록 확장

GUI 버전으로 업그레이드
