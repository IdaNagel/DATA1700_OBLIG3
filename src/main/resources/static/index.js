$(function(){
    hentAlleBilletter();
});

function hentAlleBilletter() {
    $.get( "/hentBillett", function( billett ) {
        formaterBilletter(billett);
    });
};

function formaterBilletter(billett){
    var ut = "<table class='table table-striped'>" +
        "<tr>" +
        "<th>Film</th><th>Antall</th><th>Fornavn</th><th>Etternavn</th><th>Telefonnummer</th><th>E-postadresse</th>" +
        "</tr>";
    for(let i in billett ){
        ut+="<tr>" +
            "<td>"+billett[i].film+"</td>"+
            "<td>"+billett[i].antall+"</td>"+
            "<td>"+billett[i].fornavn+"</td>"+
            "<td>"+billett[i].etternavn+"</td>"+
            "<td>"+billett[i].telefonnummer+"</td>"+
            "<td>"+billett[i].epost+"</td>"+
            "</tr>";
    }
    $("#alleBilletter").html(ut);
}

function slettBilletter() { //for å oppdatere siden når billetter slettes
    $.get("/slettBilletter", function () {
        window.location.href = 'index.html';
    });
};

function registrerBillett(){
    const billett = {
        film : $("film").val(),
        antall : $("antall").val(),
        fornavn : $("fornavn").val(),
        etternavn : $("etternavn").val(),
        telefonnummer : $("telefonnr").val(),
        epost : $("epost").val(),
    };
    $.post("/lagre",billett, function (){
        hentAlleBilletter();
    });
}

