package websites.tests

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

object XTestDimensions  {
    // run main then
    // localhost:8081/FabricFlowNode
    @JvmStatic
    fun main(args: Array<String>) {
        test();
    }

    private fun test() {
        val character:Byte = 7
        val field: Field = Field()
        val changed = field.setContent(character)

        val photonic = QuantumField()
        val change2  = photonic.setContent(2)

        val emission = photonic.emit()
        val (clone, remainder) = Absorber.materialize(emission)

        val result = clone as QuantumField

        return



    }
}