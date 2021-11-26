# Spring with RabbitMQ
스프링에서 rabbitMQ를 사용하기 위한 문서입니다
메시지 큐의 미러링 방법을 포함하고 있습니다.

::개인이 프로젝트를 구성하여 시작시, 큐에서 exchange 와 queue 가 생성되지 않는다면, RabbitListener를 설정하세요.::



## RabbitMQ (with Docker)

### 1. Dockerfile 만들기


```
vi Dockerfile


#### 내용입니다. ####
FROM rabbitmq:3-management
RUN rabbitmq-plugins enable --offline rabbitmq_mqtt rabbitmq_federation_management rabbitmq_stomp
#### 끝 ####


:wq
```


#
### 2. Docker 이미지 생성

```
docker build --tag rabbitmq:soda_flavour .

```


#
### 3. Docker 컨테이너 생성

::/각각 서버의 --hostname 옵션이 다름을 확인합니다./::

* 마스터 서버
```
docker run -d -it --name rabbitmq-1 \
--hostname mq_server_1  \
-v {서버의 mq 저장 위치}:/var/lib/rabbitmq/ \
-e RABBITMQ_DEFAULT_USER=test \
-e RABBITMQ_DEFAULT_PASS=test \
-p 15672:15672 \
-p 5671:5671 \
-p 5672:5672 \
-p 61613:61613 \
-p 61614:61614 \
-p 4369:4369  \
-p 25672:25672  \
-p 1883:1883  \
-p 8883:8883  \
rabbitmq:soda_flavour

```

* 슬레이브 서버
```
docker run -d -it --name rabbitmq-2 \
--hostname mq_server_2  \
-v {서버의 mq 저장 위치}:/var/lib/rabbitmq/ \
-e RABBITMQ_DEFAULT_USER=test \
-e RABBITMQ_DEFAULT_PASS=test \
-p 15672:15672 \
-p 5671:5671 \
-p 5672:5672 \
-p 61613:61613 \
-p 61614:61614 \
-p 4369:4369  \
-p 25672:25672  \
-p 1883:1883  \
-p 8883:8883  \
rabbitmq:soda_flavour

```


#
### 4. 각 서버의 방화벽 오픈

```
firewall-cmd --permanent --add-port=4369/tcp
firewall-cmd --permanent --add-port=25672/tcp
firewall-cmd --permanent --add-port=1883/tcp
firewall-cmd --permanent --add-port=8883/tcp
firewall-cmd --permanent --add-port=5671-5672/tcp
firewall-cmd --permanent --add-port=15672/tcp
firewall-cmd --permanent --add-port=61613-61614/tcp
firewall-cmd --reload

```

#
### 5. 각 서버의 Host 파일 수정
::마스터 슬래이브 모두 추가,  작업 서버 아이피 맞출것::

```
vi /etc/hosts

####추가 내용######
192.168.0.111   seoultel_1
192.168.0.222   seoultel_2
####끝######

:wq
```

#
### 6. Master 서버 RabbitMQ의 Erlang cookie 복사
::마스터 서버의 Erlang cookie 값을 슬레이브 서버에 복사하여 바꿈::

* 마스터 서버
```
cat {서버의 mq 저장 위치}/.erlang.cookie
# 스트링 복사

```

* 슬레이브 서버
```
docker ps
docker stop {mq 컨테이너}  -- 정지만 시킴

vi {서버의 mq 저장 위치}/.erlang.cookie
# 안에 있는 스트링을 지운 후, 마스터의 스트링으로 바꾼후 저장
:wq

docker start {mq 컨테이너}  -- 정지했던 컨테이너 시작

```

#
### 7. 각 서버 미러링 정책 설정
::마스터, 슬래이브 서버 동일::

```
docker ps 
docker exec -it {mq 컨테이너} /bin/bash

##컨테이너 안에서 - 클러스터 모든 노드의 Queue를 미러링하기
rabbitmqctl set_policy ha-all "^ha\\." '{"ha-mode":"all"}'
exit

```

#
### 8. 미러링 확인
1. 웹에서 각각 서버의 15672 포트로 접근하여 로그인
2. Overview 화면에서 Nodes 의 개수가 2개라면 성공
3. Queue 항목으로 이동하여 미러링이 정상 동작하는지 확인