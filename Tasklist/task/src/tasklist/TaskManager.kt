package tasklist

class TaskManager {

    private val taskList = mutableListOf<Task>()

    fun printTaskList() {
        if (taskList.isEmpty())
            println("No tasks have been input")

        else {
            taskList.forEachIndexed { index, task ->    println("${index + 1}   ${task.date} ${task.time} ${task.priority.letter}")
                .also {task.task.forEach { s ->  println("    $s")} } }
            println()
        }


    }

    fun addTask() {
        val task = Task.Builder().build()
        if (task.task.isNotEmpty()) taskList.add(task)

    }
}