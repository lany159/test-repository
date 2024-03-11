package com.example.kiosk

import kotlinx.coroutines.selects.select
import java.lang.StringBuilder

fun main(){
    var kiosk = Kiosk()

    while(true){
        kiosk.mainView()
        var select1 = readln().toInt()

        if (select1 == 1){
            kiosk.detailBurger()
        }else if (select1 == 2){
            kiosk.detatilSide()
        }else if (select1 == 3){
            kiosk.detailDrink()
        }else return

        println("메뉴를 추가하시겠습니까? [1] 추가 주문 [2] 추가 없음")
        var select2 = readln().toInt()
        if (select2 == 1){
            continue
        }else{
            kiosk.charge()
            println("주문이 정상적으로 완료되었습니다. 처음으로 돌아갑니다")
        }
    }
}

class Kiosk {

    val burgers = listOf<String>("불고기버거","새우버거","치킨버거")
    val sides = listOf<String>("감자튀김", "콘샐러드", "치즈스틱")
    val drinks = listOf<String>("콜라","사이다","환타")
    var charges = listOf<String>("신용카드","삼성페이","애플페이")

    fun mainView(){
        println("메뉴를 선택해주세요 [1] 버거 [2] 사이드 [3] 음료 [4] 나가기")
    }

    fun detailBurger(){
        val menuBurgers = StringBuilder()
        for(i in burgers.indices){
            menuBurgers.append("${i+1}").append(burgers[i]).append(' ')
        }
        println(menuBurgers)
        var selectBurger = readln().toInt()
        println("${burgers[selectBurger-1]}을(를) 담았습니다")
    }

    fun detatilSide(){
        val munuSides = StringBuilder()
        for(i in sides.indices){
            munuSides.append("${i+1}").append(sides[i]).append(' ')
        }
        println(munuSides)
        var selectSide = readln().toInt()
        println("${sides[selectSide-1]}을(를) 담았습니다")
    }
    fun detailDrink(){
        val munuDrinks = StringBuilder()
        for(i in drinks.indices){
            munuDrinks.append("${i+1}").append(drinks[i]).append(' ')
        }
        println(munuDrinks)
        var selectDrink = readln().toInt()
        println("${drinks[selectDrink-1]}을(를) 담았습니다")
    }

    fun addMenu(){
        println("[1] 추가 주문 [2] 추가 없음")
    }

    fun charge(){
        val chargeList = StringBuilder()
        for (i in charges.indices){
            chargeList.append("${i+1}").append(charges[i]).append(' ')
        }
        println(chargeList)
        var selectcharge = readln().toInt()
        println("${charges[selectcharge-1]}로 결제합니다")
    }
}

//메인화면 [1] 버거 [2] 사이드 [3] 음료
//상세화면 버거 [1] 불고기버거 [2] 새우버거 [3] 치킨버거
//상세화면 사이드 [1] 감자튀김 [2] 콘샐러드 [3] 치즈스틱
//상세화면 음료 [1] 콜라 [2] 사이다 [3] 환타
//추가주문 [1] 추가 주문 [2] 추가 없음
//결제수단 [1] 카드결제 [2] 현금결제
//요구 사항1 : 메인화면에서 메뉴 선택 후 추가 주문 여부 > 추가주문 시 메인화면으로 돌아갈 것
//요구 사항2 : 메뉴를 더 넣을 수 있음을 가정
//요구 사항3 : 잘못된 번호 선택 시 예외 처리
//심화 기능1 : 메뉴와 가격 출력 > 결제 수단에서 누적 합계
