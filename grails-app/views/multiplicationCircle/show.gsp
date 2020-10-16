<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Multiplication Circle</title>
    <style>
        circle, line {
            fill: white;
            stroke: rgba(255, 0, 0, 0.7);
            stroke-width: 3px;
        }
        label {
            display: block;
            float: left;
            width: 5em;
        }
    </style>
    <script>
        /**
         * @param valueName - name and id of the input element that sets the value for the input of this name.
         * @param increment - the value to add, might be 0 or negative.
         */
        function change(valueName, increment) {
            const input = document.getElementById(valueName);
            input.value = Number(input.value) + increment ;
        }
        function increase(valueName) {
            change(valueName, 1);
        }
        function decrease(valueName) {
            change(valueName, -1);
        }

    </script>
</head>
<body>
    <form action="/multiplicationCircle/index">
      <tmpl:up_down_input name="segmentCount" label="Segments" value="${circleInstance.segmentCount}" />
      <tmpl:up_down_input name="tableBase"  label="Table base" value="${circleInstance.tableBase}" />

    </form>
    <svg width="400" height="400">
        <circle r="198" cx="200" cy="200"></circle>
        <g:each var="line" in="${circleInstance.lines}">
            <line
                x1="${line.x1}"
                y1="${line.y1}"
                x2="${line.x2}"
                y2="${line.y2}">
            </line>
        </g:each>
    </svg>

</body>
</html>
