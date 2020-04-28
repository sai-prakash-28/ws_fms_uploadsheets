<!DOCTYPE html>
<html>
    <head>
        <link href="/bootstrap/4.0.0-beta/css/bootstrap.min.css"
              rel="stylesheet">
        <meta charset="UTF-8">
        <title>Feedback system</title>
        <style type='text/css'>
            h1, h2, h3, h4, h5, h6 {
                font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif;
                color: black;
                font-weight: bold;
                border-bottom: 5px solid black;
                font-style: italic;
            }

            #info {
                font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif;
                color: black;
                font-weight: 700;
                font-size: larger;
            }
            #conditions {
                font-family: sans-serif;
                font-size: smaller;
                color: black;
            }

            li {
                font-family: monospace;
                color: black;
                font-size: large;
                /* font-weight: 600; */
                /* font-style: italic; */
            }


            #fileList {
                border-style: outset;
            }
        </style>
    </head>

    <body onload="updateSize();" style="background-color:powderblue;">
    <h1 align="center">Feedback system File upload</h1>
    <p id="info">The list of Excel files which are accepted for upload*</p>
    <ul>
        <li>Volunteer_Enrollment Details_Not_Attend.xlsx</li>
        <li>Volunteer_Enrollment Details_Unregistered.xlsx</li>
        <li>outreach event summary.xlsx</li>
        <li>outreach event information.xlsx</li>
    </ul>




        <form name="uploadingForm" id="formId" enctype="multipart/form-data" action="/upload" method="POST">
            <p>
                <input id="fileInput" type="file" name="uploadingFiles" onchange="updateSize();" multiple
                       accept="*.xlsx" />
                selected files: <span id="fileNum">0</span>;
                total size: <span id="fileSize">0</span>
            </p>
            <p> Below are list of files that has been selected to upload</p>
            <div id="fileList"></div>
            <p>
                <input type="submit" value="Upload files"  onclick="clickEvent();">
                <button type="button" onclick="clearOption()" >Clear List</button>
            </p>
        </form>


    <p id="conditions">* we accept only .xlsx file for uploading into the DBs</p>
        <script>
            function updateSize() {
                var nBytes = 0,
                        oFiles = document.getElementById("fileInput").files,
                        nFiles = oFiles.length;
                for (var nFileId = 0; nFileId < nFiles; nFileId++) {
                    nBytes += oFiles[nFileId].size;
                }

                var sOutput = nBytes + " bytes";

                for (var aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
                    sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
                }

                document.getElementById("fileNum").innerHTML = nFiles;
                document.getElementById("fileSize").innerHTML = sOutput;


                var input = document.getElementById('fileInput');
                var output = document.getElementById('fileList');
                var children = "";
                for (var i = 0; i < input.files.length; ++i) {
                    children += '<li>' + input.files.item(i).name + '</li>';
                }
                output.innerHTML = '<ul>'+children+'</ul>';
            }

            function  clickEvent() {
                document.getElementById("fileList").innerHTML = "";
                document.getElementById("fileNum").innerHTML = 0;
                document.getElementById("fileSize").innerHTML = 0;
                alert("file uploaded!!!, We running some analysis and We will save the data in DB");
            }

            function clearOption() {
                document.getElementById("fileList").innerHTML = "";
                document.getElementById("fileNum").innerHTML = 0;
                document.getElementById("fileSize").innerHTML = 0;
                alert("we have cleared the upload list, now you can reselect the upload list");
            }
        </script>
    </body>
</html>