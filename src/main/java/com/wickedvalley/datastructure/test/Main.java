package com.wickedvalley.datastructure.test;

import com.baidu.aip.speech.AipSpeech;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.json.JSONObject;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map map = new HashMap();
        map = new TreeMap();
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator =  list.iterator();
        while (iterator.hasNext()){
            Integer obj= iterator.next();
            if (obj%2==0){
                iterator.remove();
            }
        }
        System.out.println(list);

    }

    public static final String APP_ID = "11664983";
    public static final String API_KEY = "sIYRpWFTTO6k4DtGjFHKmsEo";
    public static final String SECRET_KEY = "hvv6OEiK5Tm9KhNs5vM8m9FlBpaWIBoG";

    public void test() throws Exception {
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        String path = "D:\\data\\5.mp3";
        String path2 = "D:\\data\\5.pcm";
        convertMP32Pcm(path, path2);
        JSONObject asrRes = client.asr(path2, "pcm", 16000, null);
        System.out.println(asrRes);
        System.out.println(asrRes.get("result"));
    }
    public boolean convertMP32Pcm(String mp3filepath, String pcmfilepath){
        try {
            //获取文件的音频流，pcm的格式
            AudioInputStream audioInputStream = getPcmAudioInputStream(mp3filepath);
            //将音频转化为  pcm的格式保存下来
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(pcmfilepath));
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    private static AudioInputStream getPcmAudioInputStream(String mp3filepath) {
        File mp3 = new File(mp3filepath);
        AudioInputStream audioInputStream = null;
        AudioFormat targetFormat = null;
        try {
            AudioInputStream in = null;
            MpegAudioFileReader mp = new MpegAudioFileReader();
            in = mp.getAudioInputStream(mp3);
            AudioFormat baseFormat = in.getFormat();
            targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(), baseFormat.getChannels()*2, baseFormat.getSampleRate(), false);
            audioInputStream = AudioSystem.getAudioInputStream(targetFormat, in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audioInputStream;
    }


}
