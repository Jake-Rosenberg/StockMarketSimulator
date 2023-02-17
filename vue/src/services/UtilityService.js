export default {
    getValidationErrors(err) {
        let errors = ''
        // check that not of the props are undefined
        if (err && err.response && err.response.data && err.response.data.errors) {
            // err.response.data.errors.forEach(errMsg =>errors += errMsg.defaultMessage);
            errors = err.response.data.errors[0].defaultMessage;
        }
        return errors;
    }

}