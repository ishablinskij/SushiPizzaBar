async function getData () {
    let arr = [];
    for (let i = 262; i < 281; i++) {
        arr.push(`img/rolls/${i}.png`);
    }
    return arr;
}

async function main () {

    const postsData = await getData();
    let currentPage = 1;
    let rows = 9;

    function displayList(arrData, rowPerPage, page) {
        const postsEl = document.querySelector('#products');
        postsEl.innerHTML = '';
        page--;
        console.log(postsEl);

        const start = rowPerPage * page;
        const end = start + rowPerPage;
        const paginationData = arrData.slice(start, end);

        console.log(paginationData);

        paginationData.forEach((el) => {
            let frame = document.createElement('div');
            frame.className = 'stroke_3';
            frame.innerHTML += "<div class='col-md-4'>" +
                "<div class=\"v17_142\">\n" +
                "     <div class=\"v17_140\"></div>\n" +
                "          <div class=\"single_product\">\n" +
                "               <div class=\"v17_117\">\n" +
                "                    <a class=\"primary_img\" href=\"#\" data-toggle=\"modal\" data-target=\"#modal_box" + (parseInt(paginationData.indexOf(el))+1).toString() + "\"><img\n" +
                "                                                src=\"" + el + "\" style=\" margin-top: 10px; margin-right: 35px; width: 70%\" alt=\"\"></a>\n" +
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
            console.log(frame);
            postsEl.appendChild(frame);
        });

        let prev = document.querySelector('#preview');
        prev.innerHTML = '';
        for (let n = 1; n < paginationData.length+1; n++) {
            prev.innerHTML += "<div class=\"modal fade\" id=\"modal_box" + n.toString() + "\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\n" +
                "        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n" +
                "            <div class=\"modal-content\">\n" +
                "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                    <span aria-hidden=\"true\"><i class=\"icon-x\"></i></span>\n" +
                "                </button>\n" +
                "                <div class=\"modal_body\">\n" +
                "                    <div class=\"container\">\n" +
                "                        <div class=\"row\">\n" +
                "                            <div class=\"col-lg-5 col-md-5 col-sm-12\">\n" +
                "                                <div class=\"modal_tab\">\n" +
                "                                    <div class=\"tab-content product-details-large\">\n" +
                "                                        <div class=\"tab-pane fade show active\" id=\"tab1\" role=\"tabpanel\">\n" +
                "                                            <div id=\"image_preview" + n.toString() + "\" class=\"modal_tab_img\"></div>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"col-lg-7 col-md-7 col-sm-12\">\n" +
                "                                <div class=\"modal_right\">\n" +
                "                                    <div class=\"modal_title mb-10\">\n" +
                "                                        <h2>Donec Ac Tempus</h2>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"modal_price mb-10\">\n" +
                "                                        <span class=\"new_price\">$64.99</span>\n" +
                "                                        <span class=\"old_price\">$78.99</span>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"modal_description mb-15\">\n" +
                "                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia iste\n" +
                "                                            laborum ad impedit pariatur esse optio tempora sint ullam autem deleniti nam\n" +
                "                                            in quos qui nemo ipsum numquam, reiciendis maiores quidem aperiam, rerum vel\n" +
                "                                            recusandae </p>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"variants_selects\">\n" +
                "                                        <div class=\"variants_size\">\n" +
                "                                            <h2>size</h2>\n" +
                "                                            <select class=\"select_option\">\n" +
                "                                                <option selected value=\"1\">small</option>\n" +
                "                                                <option value=\"1\">middle</option>\n" +
                "                                                <option value=\"1\">big</option>\n" +
                "                                                <option value=\"1\">super big</option>\n" +
                "                                            </select>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"modal_add_to_cart\">\n" +
                "                                            <form action=\"#\">\n" +
                "                                                <input min=\"1\" max=\"100\" step=\"2\" value=\"1\" type=\"number\">\n" +
                "                                                <button type=\"submit\">add to cart</button>\n" +
                "                                            </form>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";
            let image = prev.querySelector(`#image_preview${n}`)
            console.log(image);
            image.innerHTML += "<a href=\"#\"><img src=\"" + paginationData[n-1] + "\" alt=\"\"></a>";
            console.log(prev);
        }

    }

    function displayPagination (arrData, rowPerPage) {
        const paginationEl = document.querySelector('.pagination');
        const pagesCount = Math.ceil(arrData.length / rowPerPage);
        const ulEl = document.createElement('ul');

        for (let i = 0; i < pagesCount; i++) {
            const liEl = displayPaginationBtn(i+1);
            ulEl.appendChild(liEl);
        }
        paginationEl.appendChild(ulEl);
    }

    function displayPaginationBtn (page) {
        const liEl = document.createElement('li');
        const aEl = document.createElement('a');
        aEl.innerHTML = page;
        liEl.appendChild(aEl);

        if (currentPage === page) aEl.classList.add('current');

        aEl.addEventListener('click', () => {
            currentPage = page;
            displayList(postsData, rows, currentPage);

            let currentItemLi = document.querySelector('li.current');
            currentItemLi.classList.remove('current');

            liEl.classList.add('current');
        });

        return liEl;
    }

    displayList(postsData, rows, currentPage);
    displayPagination(postsData, rows);
}

main();
