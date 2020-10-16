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
        /** @param valueName - name and id of the input element that sets the value for the input of this name. */
        function increase(valueName) {
            const input = document.getElementById(valueName);
            input.value = Number(input.value) + 1 ;
        }

        // todo: add a function to decrease the value

    </script>
</head>
<body>
    <form action="/multiplicationCircle/index">
      <tmpl:up_down_input name="segmentCount" label="Segments" value="${circleInstance.segmentCount}" />

      <!-- TODO: add an input for the table base -->

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
