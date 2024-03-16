package applications.tests.diatomics


import applications.tests.dictionary.atoms.Address
import symmetrical.dictionary.absorber.Absorber
import symmetrical.dictionary.quasiparticles.GalaxyId
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.luminescent.QuasiParticle


class VTestDiatomics  {

    fun test() : Boolean {
        if (!testDiatomics()) {
            println("VTestQuasiParticles::testParticleBeam FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }



        return true
    }


    private fun testDiatomics() : Boolean {
        val address: Address = Address().with("Here I am")
        address.illuminate()
        val debug:Boolean = address.isIlluminated()

        val emission = address.illuminate().emit()

        address.dim()



        return true
    }

    private fun testParticles() : Boolean {
        val galaxyId: QuasiParticle = GalaxyId().with("quasi")

        val radiation = galaxyId.emit()

        val (emitter: IEmitter?, remainder:String) = Absorber.materialize(radiation)

        val clone:GalaxyId = emitter as GalaxyId
        if (clone.toString() == "quasi") {
            return true
        }

        return false
    }

}