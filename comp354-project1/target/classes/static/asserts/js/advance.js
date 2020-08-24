
//these values are used to connect to backend
var operand1_input = document.querySelector("#op1");
var operator_input = document.querySelector("#op");
var operand2_input = document.querySelector("#op2");
var operand3_input = document.querySelector("#op3");
var error_output = document.querySelector("#error");

//used to determine if reset screen is needed
var resetScreen=true;
//used to determine if freezing the calculator except "ac" button is needed
var freezeCalculator=false;

//style pattern
const pattern = document.querySelector("#pattern");
pattern.addEventListener("click", function(){
    pattern.value = "clicked";
})

//toggle complex calc
const footer = document.querySelector("#footer");
footer.addEventListener("click",function(){

    var complexCalc = document.querySelector("#complexCalc");
    if (complexCalc.style.display === "none") {
        complexCalc.style.display = "block";
    } else {
        complexCalc.style.display = "none";
    }
})

//screen
const screen = document.querySelector("#screen");
make16();

//initialize screen to "0" whenever there are no exceptions
if(screen.value===""){
    screen.value = "0";
}

//whenever there's an exception/error, make the screen display that exception/error
if(error_output.textContent!==""){
    screen.value = error_output.textContent;
    freezeCalculator=true;
}

//FUNCTIONS
//check whether form is valid/unfrozen
function validateForm(){
    return !freezeCalculator;
}

//make sure display doesn't exceed 16 characters
function make16(){
    if(screen.value.length>16){
        screen.value=screen.value.substring(0,16);
    }
}

//reset all internal variables and update screen to "0", and defreeze calculator if frozen
function reset(){
    operand1_input.value="";
    operand2_input.value="";
    operand3_input.value="";
    operator_input.value="";
    error_output.value="";
    screen.value="0";
    freezeCalculator=false;
}

//BUTTONS
//OPERATORS
//button division
const div = document.querySelector("#divide");
div.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=Number(screen.value);
    operator_input.value="/";
    resetScreen=true;
})
//button multiplication
const multiply = document.querySelector("#multiply");
multiply.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=Number(screen.value);
    operator_input.value="*";
    resetScreen=true;
})
//button minus
const minus = document.querySelector("#minus");
minus.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=Number(screen.value);
    operator_input.value="-";
    resetScreen=true;
})
//button plus
const plus = document.querySelector("#plus");
plus.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=Number(screen.value);
    operator_input.value="+";
    resetScreen=true;
})

//NUMBERS
//when clicking on a number, the string of screen.value will be appended by this number
//except when the the string of screen.value is "0" or when a screen reset is needed (such as after pressing pi).
//button "0"
const zero = document.querySelector("#zero");
zero.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="0";
    }
    else{
        screen.value+="0";
    }

    resetScreen=false;
})

//button "1"
const one = document.querySelector("#one");
one.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="1";
    }
    else{
        screen.value+="1";
    }

    resetScreen=false;
})

//button "2"
const two = document.querySelector("#two");
two.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="2";
    }
    else{
        screen.value+="2";
    }

    resetScreen=false;
})

//button "3"
const three = document.querySelector("#three");
three.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="3";
    }
    else{
        screen.value+="3";
    }

    resetScreen=false;
})

//button "4"
const four = document.querySelector("#four");
four.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="4";
    }
    else{
        screen.value+="4";
    }

    resetScreen=false;
})

//button "5"
const five = document.querySelector("#five");
five.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="5";
    }
    else{
        screen.value+="5";
    }

    resetScreen=false;
})

//button "6"
const six = document.querySelector("#six");
six.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="6";
    }
    else{
        screen.value+="6";
    }

    resetScreen=false;
})

//button "7"
const seven = document.querySelector("#seven");
seven.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="7";
    }
    else{
        screen.value+="7";
    }

    resetScreen=false;
})

//button "8"
const eight = document.querySelector("#eight");
eight.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="8";
    }
    else{
        screen.value+="8";
    }

    resetScreen=false;
})

//button "9"
const nine = document.querySelector("#nine");
nine.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value.length>=16&&resetScreen==false) return;
    if(screen.value==="0"||resetScreen){
        screen.value="9";
    }
    else{
        screen.value+="9";
    }

    resetScreen=false;
})

//button "pi", screen reset is needed after pressing this button
const pi = document.querySelector("#pi");
pi.addEventListener("click",function(){
    if(freezeCalculator) return;
    screen.value = "3.14159265358";

    resetScreen=true;
})

//button "e", screen reset is needed after pressing this button
const e = document.querySelector("#e");
e.addEventListener("click",function(){
    if(freezeCalculator) return;
    screen.value = "2.71828182845";

    resetScreen = true;
})

//SPECIALS
//button "mr"
//retrieve last answer from backend from session memory
const mr = document.querySelector("#mr");
mr.addEventListener("click",function(){
    if(freezeCalculator) return;
    screen.value=sessionStorage.getItem("mr");

    resetScreen=true;
})

//button "mc"
//store what's on the screen to the session memory
const ms = document.querySelector("#ms");
ms.addEventListener("click",function(){
    if(freezeCalculator) return;
    sessionStorage.setItem("mr", screen.value);
})

//button "."
//when pressing ".", append "." to the screen.value string, unless there's already a dot in screen.value string
//when reset string is required, pressing "." will make screen.value "0."
const dot = document.querySelector("#dot");
dot.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(resetScreen){
        screen.value="0.";
    }
    else if(!screen.value.includes(".")){
        screen.value+=".";
    }

    resetScreen=false;
 })

//button "(-)"
//when pressing "(-)", the screen.value string's sign must be reverted
//ex. "-10.23" becomes "10.23", and "10.23" becomes "-10.23"
//"0" is unchanged
const neg = document.querySelector("#neg");
neg.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(screen.value==="0"){
        return;
    }
    else{
        if(screen.value[0]==='-'){
            screen.value=screen.value.substr(1);
        }
        else{
            screen.value="-"+screen.value;
        }
    }

    resetScreen=false;
})

//button "ac"
//resetting all variables.
const ac = document.querySelector("#ac")
ac.addEventListener("click",function(){
    reset();
})

//button "="
//transmits data to backend
const equal = document.querySelector("#equal");
equal.addEventListener("click",function(){
    if(freezeCalculator) return;
    if(operator_input.value==="pow"
            ||operator_input.value==="+"
            ||operator_input.value==="-"
            ||operator_input.value==="*"
            ||operator_input.value==="/")
    {
        operand2_input.value=screen.value;
    }
    resetScreen=true;
})

//transcendental functions
//button "sin"
const sin = document.querySelector("#sin");
sin.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=screen.value;
    operator_input.value="sin";
    resetScreen=true;
})

//button "e^x"
const exp = document.querySelector("#exp");
exp.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=screen.value;
    operator_input.value="exp";
    resetScreen=true;
})

//button "x^y"
const pow = document.querySelector("#pow");
pow.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=screen.value;
    operator_input.value="pow";
    operator="pow";
    resetScreen=true;
})

//button "10^x"
const exp10 = document.querySelector("#exp10");
exp10.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=screen.value;
    operator_input.value="exp1o";
    resetScreen=true;
})

//button "log"
const log = document.querySelector("#log");
log.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=screen.value;
    operator_input.value="log";
    resetScreen=true;
})

//button "sinh"
const sinh = document.querySelector("#sinh");
sinh.addEventListener("click",function(){
    if(freezeCalculator) return;
    operand1_input.value=screen.value;
    operator_input.value="sinh";
    resetScreen=true;
})








