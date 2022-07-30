package tasklist

class MenuManager {

    private val taskManager = TaskManager()

    fun startMenu() {
        while (true) {
            println("Input an action (add, print, end):")
            when (readln().lowercase()) {
                "add" -> taskManager.addTask()
                "print" -> taskManager.printTaskList()
                "end" -> println("Tasklist exiting!").run { return }
                else -> println("The input action is invalid")
            }
        }
    }
}