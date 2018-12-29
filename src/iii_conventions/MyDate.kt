package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
            if (this.year > other.year) return 1
            if (this.year < other.year) return -1
            if (this.month > other.month) return 1
            if (this.month < other.month) return -1
            if (this.dayOfMonth > other.dayOfMonth) return 1
            if (this.dayOfMonth < other.dayOfMonth) return -1
            return 0
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}
operator fun TimeInterval.times(i: Int) = TimeIntervals(this, i)

data class TimeIntervals(val ti: TimeInterval, val num: Int) {}

operator fun MyDate.plus(ti: TimeInterval) = this + TimeIntervals(ti, 1)
operator fun MyDate.plus(ti: TimeIntervals) = addTimeIntervals(ti.ti, ti.num)


class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {

    operator fun contains(d: MyDate): Boolean {
        return (start <= d && endInclusive >= d)
    }

    override operator fun iterator() = object: Iterator<MyDate> { 
        private var current = start
        override operator fun hasNext() = current <= endInclusive
        override operator fun next():MyDate { val c = current; current = current.nextDay(); return c } 
        }
}

