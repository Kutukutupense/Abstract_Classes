//Abstract classlar, o class a ait en temel özellikleri barındırırlar.
// Abstract classlar kesinlikle miras alınırlar ve nesnesi oluşturulamaz.
// Ancak onu miras alan classlar içinde bir anlam kazanırlar. Abstract olmayan bir class tarafından
// miras alınırlanken tüm abstract keyword ü ile başlayan değerleri override edilmek zorundadır.
//  abstract keyword ü almayan  diğer  tüm değerleri kullanmak opsiyoneldir.
// fakat bir abstract class diğer bir abstract class ı miras alıyorsa abstract keyword ü ile başlayan
//değişkenleri override etmek zorunda değildir.
//constructer ve secondary constructer alabilirler.
// aşağıdaki örnekte insan sınıfı abstract olarak tanımlandı çünkü insanın en temel özellikleri
// verildi. Sonrasında gelen Turks sınıfı Human ı miras aldı ve içine 1 tane türklere özgü özellik
// el şakası dahil edildi. Trakyalılar ve Doğu anadolular sınıfı ise Turks ü miras aldığında
//zaten abstract human sınıfının özelliklerine ulaşabiliyor.Böylece yukardan aşağıya doğru
//bir mimari kurulmuş oldu.

abstract class Human{

    abstract val name:String
    abstract val age:Int
    abstract fun talk()

    val eyeColor:String = "Blue"        // abtract olmayan property verilebilir opsiyonel kullanım için

    fun sing(){                         // abstract olmayan fonksiyon tanımlanabilir opsiyonel kullanım için
        println("şarkı söylüyor")
    }

    abstract class deneme:Human(){
        // abstract class diğer bir abstract class ı miras aldığı için
        // değişkenleri override etmek zorunda kalmadık.
    }




}

open class Turks: Human(){
    override var name: String = ""  // eğer bu şekilde bu değişkeni burada kullanmayacak ve default değer vermek zorunda
                                    //kalmak istemiyorsak bunu open class Turks(override var name:String): Human(){}
                                    // şeklinde de tanımlayabilir ve Turks bodysi içinde hiç yazmaz ve değer vermezdik.

    override var age: Int = 0       // aynı şekilde bunu da.


    override fun talk() {
        println("Talking")
    }
    open fun handJoke(){
        println("Doing Handjoke")
    }

// eğer bir classda override edilen bir değişkeni ya fonksiyonu onun diğer alt classları tarafından override edilmesini
// engellemek istersek başına final keyword u getiririz. final override val name:String - final override fun talk() gibi.

}
 class Thracians: Turks(){
    override var name = ""
    override  var age = 0
    override fun talk() {
        println("Talking like Thracian way")
    }

     override fun handJoke() {
         println("Doing Handjoke To Head")
     }



}

class EastAnatolian: Turks(){
    override var name = ""
    override  var age = 0
    override fun talk() {
        println("Talking like East Anatolian way")
    }

    override fun handJoke() {
        println("Doing Handjoke to Belly")
    }
}

fun main(){
    val thracian1 = Thracians()
    thracian1.name = "Hasan"
    thracian1.age = 46
    println("Name: ${thracian1.name}  Age: ${thracian1.age}")
    thracian1.talk()
    thracian1.handJoke()

    val eastAnatolian1 = EastAnatolian()
    eastAnatolian1.name = "Recep"
    eastAnatolian1.age = 22
    println("Name: ${eastAnatolian1.name}  Age: ${eastAnatolian1.age}")
    eastAnatolian1.talk()
    eastAnatolian1.handJoke()


}