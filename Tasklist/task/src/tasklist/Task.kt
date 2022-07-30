package tasklist

import kotlinx.datetime.LocalDate
import java.time.LocalTime

data class Task(val task: MutableList<String>, val date: String, val time: String, val priority: Priority) {

    class Builder {

        fun build(): Task {
            val priorityOfTask: Priority = getTaskPriority()
            val deadLineDateOfTask: String = getDeadLineDate()
            val deadLineTime: String = getDeadLineTime()
            val task: MutableList<String> = getTask()
            return Task(task, deadLineDateOfTask, deadLineTime, priorityOfTask)
        }

        private fun getTask(): MutableList<String> {
            var input: String
            val task = mutableListOf<String>()
            println("Input a new task (enter a blank line to end):")
            while (readln().trim()
                    .also { input = it }
                    .isNotBlank()) task.add(input)

            return task
        }

        private fun getDeadLineTime(): String {
            var input: List<String>
            while (true) {
                println("Input the time (hh:mm):")
                input = readln().split(":")
                try {
                    LocalTime.of(input[0].toInt(), input[1].toInt())
                    break
                } catch (e: Exception) {
                    println("The input time is invalid")
                }
            }
            return formatTime(input).joinToString(":")
        }
        //convert h:m to hh:mm
        private fun formatTime(time: List<String>): List<String> {
            return time.map { (if (it.length == 1) "0$it" else it).toString() }
        }

        private fun getDeadLineDate(): String {
            var input: List<String>
            while (true) {
                println("Input the date (yyyy-mm-dd):")
                input = readln().split('-')
                try {
                    val arr = input.map { it.toInt() }.toIntArray()
                    LocalDate(arr[0], arr[1], arr[2])
                    break
                } catch (e: Exception) {
                    println("The input date is invalid")
                }
            }
            return input.joinToString("-")

        }

        private fun getTaskPriority(): Priority {
            while (true) {
                println("Input the task priority (C, H, N, L):")
                return when (readln().uppercase()){
                    "C" -> Priority.CRITICAL
                    "H" -> Priority.HIGH
                    "N" -> Priority.NORMAL
                    "L" -> Priority.LOW
                    else -> continue
                }
            }
        }
    }
}

enum class Priority(val letter: String){
    CRITICAL ("C"),
    HIGH("H"),
    NORMAL("N"),
    LOW("L"),


}