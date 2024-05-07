async function getData () {
    let arr = [];
    for (let i = 0; i < 12; i++) {
        arr.push(`img/product/productsImg/product${i+1}.jpg`);
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
            frame.className = 'stroke_3'
            frame.innerHTML += "<div class='col-md-4'>" +
                "<div class=\"v17_142\">\n" +
                "     <div class=\"v17_140\"></div>\n" +
                "          <div class=\"single_product\">\n" +
                "               <div class=\"v17_117\">\n" +
                "                    <a class=\"primary_img\" href=\"#\" data-toggle=\"modal\" data-target=\"#modal_box\"><img\n" +
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
