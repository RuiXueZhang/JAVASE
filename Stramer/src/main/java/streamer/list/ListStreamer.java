package streamer.list;

import org.junit.Test;
import streamer.material.StreamType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListStreamer {

    @Test
    public void list(){

        List<StreamType> streamTypes = new ArrayList<>();
        streamTypes.add(StreamType.H5);
        streamTypes.add(StreamType.RTMP);

        List<String> stringList = streamTypes.stream().map(Enum::name).collect(Collectors.toList());
        System.out.println(stringList);

    }
}
