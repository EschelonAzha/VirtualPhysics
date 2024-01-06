package symmetrical.cosmic.absorber

import asymmetrical.physics.machine.config.Config
import symmetrical.cosmic.absorber.class_groups.*
import symmetrical.cosmic.transpectors.transpectors.Strings
import symmetrical.cosmic.physics.subatomic.bosons.*
import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import kotlin.reflect.KClass

object Absorber : IAbsorber {
    val beam: ClassGroup = ClassGroup()
    init {
        beam.addAll(AppClasses())
        beam.addAll(Atoms())
        beam.addAll(Dimentions())
        beam.addAll(Charges())
        beam.addAll(Compounds())
        beam.addAll(Cosmic())
        beam.addAll(DictionaryGroup())
        beam.addAll(Encodings())
        beam.addAll(FundamentalProperties())
        beam.addAll(Hadrons())
        beam.addAll(Ions())
        beam.addAll(Leptons())
        beam.addAll(Quarks())
        beam.addAll(Spacial())

    }


    override fun addAll(group:ClassGroup) : Absorber {
        beam.addAll(group)
        return this
    }
    override fun createInstance(id:String) : Any? {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.id == id) {
                return newInstance(entityId.kClass)
            }
        }
        return null
    }
    override fun getClassId(kClass: KClass<*>) : String {

        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.kClass == kClass)
                return entityId.id
        }
        println("")
        println("!!!!!!!!!!!!!!!!!!!")
        println("PhotonDetector::getClassId(kClass:KClass could not find: $kClass")
        println("!!!!!!!!!!!!!!!!!!!")
        println("")
        return ""
    }
    override fun initialize() : Absorber {
        beam.print()
        return this
    }
    override fun initialize(group:ClassGroup) : Absorber {
        beam.addAll(group)
        beam.print()
        return this
    }
    override fun materialize(emission:String) : Pair<IEmitter, String> {
        var (classId, remainder) = Strings.remainder(Config.getClassIdLth(), emission)
        val clone = createInstance(classId) as IEmitter
        val remainderPhoton: Photon = clone.absorb(Photon(emission))
        return Pair<IEmitter, String>(clone, remainderPhoton.radiate())
    }
    override fun materialize(photon: Photon) : Pair<IEmitter, String> {
        return materialize(photon.radiate())
    }

    override fun newInstance(kClass:KClass<*>) : Any? {
        for (i:Int in 0 until beam.size()) {
            val entityId:EntityId = beam.get(i) as EntityId
            if (entityId.has(kClass))
                return entityId.newInstance()
        }
        return null
    }

}

