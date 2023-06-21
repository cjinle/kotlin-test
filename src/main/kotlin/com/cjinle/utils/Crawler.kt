package com.cjinle.utils

import org.jsoup.Jsoup

class Crawler {

    private val host = "https://www.51voa.com"

    fun run() {
//        getPostList()
        getPost()
    }

    fun getPostList() {
        val doc = Jsoup.connect("$host/Technology_Report_1.html").get()
        println("title: ${doc.title()}")
        val elements = doc.select("div.list ul li")
        for (li in elements) {
            for (a in li.select("a")) {
                var href = a.attr("href")
                if (href.indexOf("/lrc") > -1) {
                    continue
                }
                if (href.indexOf("_1.html") > -1) {
                    continue
                }
                println("text: ${a.text()}")
                println(href)

            }
        }
    }

    fun getPost() {
        val path = "/VOA_Special_English/new-image-shows-violent-events-near-a-supermassive-black-hole-90827.html"
        val doc = Jsoup.connect(host+path).get()
        println("title: ${doc.title()}")
        val elements = doc.select("div.content p")
        for (el in elements) {
            println(el.text())
        }
    }

}