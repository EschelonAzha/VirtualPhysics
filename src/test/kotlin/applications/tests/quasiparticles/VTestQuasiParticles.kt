package applications.tests.quasiparticles

import applications.tests.dictionary.atoms.Address
import symmetrical.dictionary.absorber.Absorber
import symmetrical.dictionary.protons.AccessLevelProton
import symmetrical.dictionary.quasiparticles.GalaxyId
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.physics.subatomic.spacial.ParticleBeam

class VTestQuasiParticles  {

    fun test() : Boolean {
        if (!testParticleBeam()) {
            println("VTestQuasiParticles::testParticleBeam FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        if (!testParticles()) {
            println("VTestQuasiParticles::testParticles FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }

        return true
    }


    private fun testParticleBeam() : Boolean {
        val galaxyId: QuasiParticle = GalaxyId().with("quasi")

        val beam = ParticleBeam()
        beam.add(galaxyId)

        val radiation = beam.emit()
        val (emitter, remainder) = Absorber.materialize(radiation)

        val clone = emitter as ParticleBeam

        val idClone = clone.get(0) as GalaxyId
        if (idClone.toString() == "quasi")
            return true
        return false
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