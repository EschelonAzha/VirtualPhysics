package websites.tests

import websites.tests.alloys.LeftRight
import websites.tests.alloys._Left
import websites.tests.alloys._Right


object XTestAlloys {
    // run main then
    // localhost:8081/FabricFlowNode
    @JvmStatic
    fun main(args: Array<String>) {
        test();
    }

    private fun test() {
        var left   = _Left()
        var right  = _Right()

        var testAlloy  = LeftRight(left, right)
        var testAlloy2 = LeftRight(testAlloy.getLeft(), testAlloy.getRight())

        println(testAlloy.getLeftValue())
        println(testAlloy.getRightValue())

        testAlloy.setRightValue("righty")
        testAlloy.setLeftValue("lefty")


        println(testAlloy2.getLeftValue())
        println(testAlloy2.getRightValue())

        println(testAlloy2.getValue())
        testAlloy.start();
        memoryTest(left, right);
        return
    }

    fun memoryTest(left:_Left, right:_Right) : Unit {
        var i=999;
        while (i>0) {
            var j=999;
            while (j>0) {
                LeftRight(left, right);
                j--;
            }
            i--;
        }
    }
}