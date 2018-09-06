#version 330

in vec3 aPosition;
in vec2 aTexCoord;
		
uniform mat4 uWorld;
uniform mat4 uView;
uniform mat4 uProjection;

void main(void) 
{
    gl_Position = 
        uProjection * uView * uWorld *
        vec4(aPosition, 1.0);
}