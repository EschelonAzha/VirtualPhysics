package websites.tests

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumPhotonicField
import websites.tests.alloys._Left
import websites.tests.alloys._Right

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
        val changed = field.setValue(character)

        val photonic = QuantumPhotonicField()
        val change2  = photonic.setValue(2)

        val emission = photonic.emit()
        val (clone, remainder) = Absorber.materialize(emission)

        val result = clone as QuantumPhotonicField

        return



    }
}