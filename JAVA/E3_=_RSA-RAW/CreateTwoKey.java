import java.math.BigInteger;

public class CreateTwoKey {

    public static KeyPair createPublicAndPrivateKeys(){
       BigInteger p=Alea.getPrimeNumber();
       BigInteger q=Alea.getPrimeNumber();
       BigInteger n = p.multiply(q);
       BigInteger w = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
       int result = 0;
        BigInteger d=Alea.getPrimeNumber();
        while(result!= -1){
            d=  Alea.getPrimeNumber() ;
            result =d.compareTo(w) ;
       }
       BigInteger e = d.modInverse(w);
       PublicKey publicKey = new PublicKey(n,e);
       PrivatKey privatKey = new PrivatKey(d);
       return new KeyPair(publicKey,privatKey);
    }

    public static void main(String[] args) {
        KeyPair key =createPublicAndPrivateKeys();
        System.out.println("Public Key: (" + key.publicKey() + ", " + key.privatKey() + ")");

    }

}
