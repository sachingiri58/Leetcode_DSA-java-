/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    if (this.length === 0) {
        return -1;   // as required in the problem
    }
    return this[this.length - 1];
};

/**
 * Example usage:
 * const arr = [1, 2, 3];
 * console.log(arr.last()); // 3
 * console.log([].last());  // -1
 */
