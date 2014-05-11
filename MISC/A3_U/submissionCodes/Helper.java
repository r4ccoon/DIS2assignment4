

public class Helper {

    public static int Convert(
            int sizeType,
            float size,
            int realWidth,
            int realHeight)
    {

        switch (sizeType){
            case SizeType.height:
                return  (int)(size * realHeight);

            case SizeType.width:
                return (int)(size * realWidth);
        }

        return 0;
    }


}
