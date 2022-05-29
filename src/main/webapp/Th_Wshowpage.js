function showpage(page) {
    if (page == 1) {
        document.getElementById("page1").style.display = "block";
        document.getElementById("page2").style.display = "none";
        document.getElementById("page3").style.display = "none";
        document.getElementById("page4").style.display = "none";
        document.getElementById("page5").style.display = "none";
        //document.getElementById("page6").style.display="none";

        /*下面是颜色的变化  */
        document.getElementById("td1").style.backgroundColor = "#dbe6f4";
        document.getElementById("td2").style.backgroundColor = "#cfdef3";
        document.getElementById("td3").style.backgroundColor = "#cfdef3";
        document.getElementById("td4").style.backgroundColor = "#cfdef3";
        document.getElementById("td5").style.backgroundColor = "#cfdef3";
    }
    if (page == 2) {
        document.getElementById("page2").style.display = "block";
        document.getElementById("page1").style.display = "none";
        document.getElementById("page3").style.display = "none";
        document.getElementById("page4").style.display = "none";
        document.getElementById("page5").style.display = "none";
        /*下面是颜色的变化  */
        document.getElementById("td1").style.backgroundColor = "#cfdef3";
        document.getElementById("td2").style.backgroundColor = "#dbe6f4";
        document.getElementById("td3").style.backgroundColor = "#cfdef3";
        document.getElementById("td4").style.backgroundColor = "#cfdef3";
        document.getElementById("td5").style.backgroundColor = "#cfdef3";
    }
    if (page == 3) {
        document.getElementById("page3").style.display = "block";
        document.getElementById("page2").style.display = "none";
        document.getElementById("page1").style.display = "none";
        document.getElementById("page4").style.display = "none";
        document.getElementById("page5").style.display = "none";
        /*下面是颜色的变化  */
        document.getElementById("td1").style.backgroundColor = "#cfdef3";
        document.getElementById("td2").style.backgroundColor = "#cfdef3";
        document.getElementById("td3").style.backgroundColor = "#dbe6f4";
        document.getElementById("td4").style.backgroundColor = "#cfdef3";
        document.getElementById("td5").style.backgroundColor = "#cfdef3";
    }
    if (page == 4) {
        document.getElementById("page4").style.display = "block";
        document.getElementById("page2").style.display = "none";
        document.getElementById("page1").style.display = "none";
        document.getElementById("page3").style.display = "none";
        document.getElementById("page5").style.display = "none";
        /*下面是颜色的变化  */
        document.getElementById("td1").style.backgroundColor = "#cfdef3";
        document.getElementById("td2").style.backgroundColor = "#cfdef3";
        document.getElementById("td3").style.backgroundColor = "#cfdef3";
        document.getElementById("td4").style.backgroundColor = "#dbe6f4";
        document.getElementById("td5").style.backgroundColor = "#cfdef3";
    }
    if (page == 5) {
        document.getElementById("page5").style.display = "block";
        document.getElementById("page2").style.display = "none";
        document.getElementById("page1").style.display = "none";
        document.getElementById("page4").style.display = "none";
        document.getElementById("page3").style.display = "none";
        /*下面是颜色的变化  */
        document.getElementById("td1").style.backgroundColor = "#cfdef3";
        document.getElementById("td2").style.backgroundColor = "#cfdef3";
        document.getElementById("td3").style.backgroundColor = "#cfdef3";
        document.getElementById("td4").style.backgroundColor = "#cfdef3";
        document.getElementById("td5").style.backgroundColor = "#dbe6f4";
    }

}
