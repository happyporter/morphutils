# morphutils

<pre>
- 유사어 추출 및 단어 추출 예제
- 샘플 소스는 App.java 입니다.
</pre>

<hr />

## 1. 표제어

<pre>
올해 크리스마스에는 눈이 내리지 않고 비교적 포근할 전망이다.
</pre>

## 2. 유사어 추출 결과

<pre>
- 검색어 1 : 올해 크리스마스에는
- 검색어 2 : 올해 크리스마스에는 눈이 내리지 않고
- 검색어 3 : 올해 크리스마스에는 눈이 내리지 않고 비교적 포근할 전망이다.


- 유사어 1 : 올해 크리스마스에는 눈이 내리지 않고 비교적 포근할 전망이다.(1.0)
- 유사어 2 : 올해 크리스마스에는 눈이 내리지 않고(0.9176470588235295)
- 유사어 3 : 올해 크리스마스에는(0.8588235294117647)
</pre>


## 3. 단어 추출 결과

<pre>
올해
크리스마스
눈
내리
않
비교적
포근
전망
</pre>


<hr />

* 참고사이트

<pre>
https://github.com/korlucene
http://cafe.naver.com/korlucene
https://github.com/jordanthomas/jaro-winkler
</pre>

<hr />

* 주의사항

<pre>
jdk 1.7 기반입니다.
</pre>
