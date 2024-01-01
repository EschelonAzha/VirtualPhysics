package symmetrical.cosmic.__recycle

import asymmetrical.machine.config.Config
import symmetrical.cosmic.__recycle.class_groups.*
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.*
import kotlin.reflect.KClass

object Absorber {
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
        beam.print()
    }



    fun createInstance(id:String) : Any? {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.id == id) {
                return newInstance(entityId.kClass)
            }
        }
        return null
    }
    fun getClassId(kClass: KClass<*>) : String {

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
    fun initialize() : Absorber {
        return this
    }
    fun materialize(emission:String) : Pair<IEmitter, String> {
        var (classId, remainder) = Strings.remainder(Config.getClassIdLth(), emission)
        val clone = createInstance(classId) as IEmitter
        val remainderPhoton: Photon = clone.absorb(Photon(emission))
        return Pair<IEmitter, String>(clone, remainderPhoton.radiate())
    }
    fun materialize(photon: Photon) : Pair<IEmitter, String> {
        return materialize(photon.radiate())
    }

    private fun newInstance(kClass:KClass<*>) : Any? {
        for (i:Int in 0 until beam.size()) {
            val entityId:EntityId = beam.get(i) as EntityId
            if (entityId.has(kClass))
                return entityId.newInstance()
        }
        return null
    }

}

