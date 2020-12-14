 function getPDF() {
    const pdf = new jspdf('p', 'pt', 'letter');
    pdf.canvas.height = 72 * 11;
    pdf.canvas.width = 72 * 8.5;
    const text = document.getElementById("index");
    pdf.fromHTML(text);
    pdf.save('test.pdf');
}