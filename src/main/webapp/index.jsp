<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Table plugin</title>
    <link rel="stylesheet" href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Medical App </a>
        </div>

        <ul class="navbar-nav">

        </ul>
    </nav>
</header>
<br>


    <div class="container">
        <h2>Events</h2>
        <table class="table" id="myTable">
            <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Date</th>
                <th>Time</th>
                <th>Assignment</th>
                <th>Status</th>
                <th>Patient</th>
                <th>Comments</th>
            </tr>
            </thead>
            <tbody id="tb">
            <tr>
                <td>318</td>
                <td>null</td>
                <td>null</td>
                <td>Fisioterapy</td>
                <td>Sheduled</td>
                <td>Petrova</td>
                <td>add comment</td>
            </tr>
            <tr>
                <td>319</td>
                <td>null</td>
                <td>null</td>
                <td>Fisioterapy</td>
                <td>Sheduled</td>
                <td>Sidorova</td>
                <td>add comment</td>
            </tr>
            <tr>
                <td>320</td>
                <td>null</td>
                <td>null</td>
                <td>Fisioterapy</td>
                <td>Sheduled</td>
                <td>Ivanova</td>
                <td>add comment</td>
            </tr>
            </tbody>
        </table>
    </div>

    <script>
        alert("hi");
        var ws = new WebSocket("ws://localhost:8081/medEjb/push");
        ws.onmessage  = function f(json_string) {

            class Table {
                constructor(rows) {
                    this.rows = rows;
                    this.createRows();
                }

                //CREATE ROWS
                createRows() {
                    let tbody = document.getElementById("myTable").tBodies[0];
                    rows.forEach(row => {
                        let trRow = document.createElement("tr");
                        tbody.appendChild(trRow);
                        let values = Object.values(row);
                        for (let value of values) {
                            let td = document.createElement("td");
                            let tdContent = document.createTextNode(value);
                            td.appendChild(tdContent);
                            trRow.appendChild(td);
                        }
                    });
                }
            }

            let rows = JSON.parse(json_string.data+"");

            //deleting rows
            let tbody = document.getElementById("myTable").getElementsByTagName("tbody")[0];
            while (tbody.rows.length>0) {
                tbody.deleteRow(0);
            }

            const table = new Table(rows);
        };
    </script>
</body>

</html>