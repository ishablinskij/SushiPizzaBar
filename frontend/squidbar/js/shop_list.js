
for (let i = 0; i < 3; i++) {
    let frame = document.createElement('div');
    frame.className = 'stroke_3'
    for (let j = 0; j < 3; j++) {
        frame.innerHTML += "<div class='col-md-4'>" +
            "<div class=\"v17_142\">\n" +
            "     <div class=\"v17_140\"></div>\n" +
            "          <div class=\"single_product\">\n" +
            "               <div class=\"v17_117\">\n" +
            "                    <a class=\"primary_img\" href=\"#\" data-toggle=\"modal\" data-target=\"#modal_box\"><img\n" +
            "                                                src=\"img/product/png/pizza1.png\" style=\" margin-top: 10px; margin-right: 35px; width: 70%\" alt=\"\"></a>\n" +
            "\n" +
            "                    <div class=\"action_links\">\n" +
            "                         <ul>\n" +
            "                                <li class=\"quick_button\"><a href=\"#\" data-toggle=\"modal\"\n" +
            "                                               data-target=\"#modal_box\" title=\"quick view\"> <i\n" +
            "                                          class=\"icon-eye\"></i></a></li>\n" +
            "                         </ul>\n" +
            "                                 </div>\n" +
            "                                        <div class=\"action_links list_action\">\n" +
            "                                            <ul>\n" +
            "                                                <li class=\"quick_button\"><a href=\"#\" data-toggle=\"modal\"\n" +
            "                                                                            data-target=\"#modal_box\" title=\"quick view\"> <i\n" +
            "                                                        class=\"icon-eye\"></i></a></li>\n" +
            "                                            </ul>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                    <span class=\"v17_122\">Pepperoni</span>\n" +
            "                                    <span class=\"v17_123\">1 kg</span>\n" +
            "                                    <span class=\"v17_129\">30 centimeters</span>\n" +
            "                                    <span class=\"v17_130\">1000$</span>\n" +
            "                                </div>\n" +
            "                            </div>" +
            "</div>";
    }
    document.getElementById('products').innerHTML += frame.innerHTML
}
