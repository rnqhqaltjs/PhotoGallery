# Photo Gallery  
기존의 과제를 완성한 프로젝트를 Jetpack Compose와 멀티 모듈 구조로 리팩토링하였습니다.  
https://github.com/rnqhqaltjs/9th-aos-prography-quest

## 이미지 다운로드 기능 구현

### DownLoadManager vs MediaStore
여러 고민 끝에 DownLoadManager를 사용하여 이미지 다운로드 기능을 구현하였습니다.

### Why Use DownloadManager?
- #### 상대적으로 간단한 구현  
DownloadManager는 Android에서 파일 다운로드를 간편하게 처리할 수 있는 API로, 복잡한 설정 없이 쉽게 사용할 수 있습니다. 앱 내에서 간단한 다운로드 기능만을 사용할 계획이기 때문에 DownloadManager를 선택했습니다.

- #### 백그라운드 다운로드 처리  
DownloadManager는 백그라운드에서 다운로드 작업을 처리할 수 있도록 설계되었습니다. 사용자가 앱을 사용하지 않을 때에도 다운로드를 계속 진행할 수 있어 사용자 경험을 향상시킵니다.

- #### 헤더 인증 지원  
DownloadManager는 API 호출 시 필요한 인증 정보를 요청에 포함시킬 수 있습니다. 일반적으로 DownloadManager의 Request 객체에서 addRequestHeader 메서드를 사용하여 헤더를 추가할 수 있습니다. 이를 통해 별도의 OkHttp 빌더를 사용하지 않고도 인증이 필요한 URL에 대한 요청을 쉽게 처리할 수 있습니다.

