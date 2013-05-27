/**
 * Main javascript file for NSESH project
 */
var nsesh = nsesh || {};

nsesh.getCommonParent = function(el1,el2) {
    var parents1 = [];
    var el = el1;
    while(el.length != 0) {
        parents1.push(el);
        el = el.parent();
    }
    
    console.log(parents1);
 
    var parents2 = [];
    var el = el2;
    while(el.length != 0) {
        parents2.push(el);
        el = el.parent();
    }
    
    console.log(parents2);
 
    var i = 0;
 
    while(i<parents1.length && i<parents2.length && parents1[i+1] == parents2[i+1]) {
//        console.log(i);
//        console.log('parents1[i+1] == ' + parents1[i+1]);
//        console.log('parents2[i+1] == ' + parents2[i+1]);
//        i++;
        console.log(i);
    }
 
    return parents1[i + 1];
};

$(function() {
  //show tabs
    $('#tabs').tabs();
    
    //console.log(getCommonParent($('#logo'), $('#search')));
});