public class Main {
    public static void main(String[] args) {
      SaveinfotoDB saveinfotoDB=new SaveinfotoDB();
      Thread thread1=new Thread(saveinfotoDB);
      Showinfo showinfo=new Showinfo();
      Thread thread2=new Thread(showinfo);
      Showtextfile showtextfile=new Showtextfile();
      Thread thread3=new Thread(showtextfile);
      thread1.start();
      thread3.start();
      thread2.start();

    }

}
