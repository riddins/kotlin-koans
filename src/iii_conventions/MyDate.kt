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

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(d: MyDate): Boolean {
        return (start <= d && endInclusive >= d)
    }
}

