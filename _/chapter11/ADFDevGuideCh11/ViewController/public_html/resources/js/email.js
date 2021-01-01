
function EmailClientValidator() {
    // for debugging
    this._class = "EmailClientValidator";
}

EmailClientValidator.prototype = new TrValidator();
EmailClientValidator.prototype.validate = function (value, label, converter) {
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(value)) {
        var fm = new TrFacesMessage("Email validation failed", "Invalid Email", TrFacesMessage.SEVERITY_ERROR);
        throw new TrValidatorException(fm);
    }
}